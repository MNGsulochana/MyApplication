package com.example.sulochana.myapplication.keyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.example.sulochana.myapplication.R;

public class InputView extends LinearLayout {
    
    private InputListener listener;
        private int count, inputType, textColor, hintColor, viewsPadding, textSize, innerViewsMargin;
        @DrawableRes private int drawableIcon;
        private String hint;

        public InputView(Context context) {
            super(context);
            init(null);
        }

        public InputView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(attrs);
        }

        public InputView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(attrs);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public InputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            init(attrs);
        }

        public InputView setHint(String hint) {
            this.hint = hint;
            return this;
        }

        public InputView setCount(int count) {
            this.count = count;
            return this;
        }

        public InputView setInputType(int inputType) {
            this.inputType = inputType;
            return this;
        }

        public InputView setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public InputView setHintColor(int hintColor) {
            this.hintColor = hintColor;
            return this;
        }

        public InputView setViewsPadding(int viewsPadding) {
            this.viewsPadding = viewsPadding;
            return this;
        }


        public InputView setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        private void init(AttributeSet attrs) {
            int padding = (int) dp2px(8);
            setPadding(padding, padding, padding, padding);
            setFocusable(true);
            setFocusableInTouchMode(true);
            TypedArray styles = getContext().obtainStyledAttributes(attrs, R.styleable.InputView);
            count = styles.getInt(R.styleable.InputView_count, 5);
            inputType = styles.getInt(R.styleable.InputView_inputType, InputType.TYPE_CLASS_TEXT);
            textColor = styles.getInt(R.styleable.InputView_textColor, -1);
            hintColor = styles.getInt(R.styleable.InputView_hintColor, -1);
            // viewsPadding = styles.getInt(R.styleable.InputClass_viewsPadding, -1);
            viewsPadding = styles.getInt(R.styleable.InputView_viewsPadding, 5);
            hint = styles.getString(R.styleable.InputView_otpHint);
            textSize = styles.getInt(R.styleable.InputView_textSize, -1);

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawableIcon = styles.getResourceId(R.styleable.InputView_backgroundDrawable, R.drawable.ic_transparent_background);
            }
            innerViewsMargin = styles.getInt(R.styleable.InputView_innerViewsMargin, 10);

            // innerViewsMargin = styles.getInt(R.styleable.InputClass_innerViewsMargin, 0);

            String text = styles.getString(R.styleable.InputView_otpText);

            fillLayout();

            setOtp(text);
        }

        public void fillLayout() {
            clearLayout();
            for (int i = 0; i < count; i++) {
                InputEditText editText = new InputEditText(getContext(), i);
                editText.setInputType(inputType);
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);

                if (innerViewsMargin != -1) {
                    setViewsMargins(editText, innerViewsMargin);
                }
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && drawableIcon != -1) {
                    editText.setBackground(getContext().getDrawable(drawableIcon));
                }
                if (textColor != -1) {
                    editText.setTextColor(textColor);
                }
                if (hintColor != -1) {
                    editText.setHintTextColor(hintColor);
                }
                if (viewsPadding != -1) {
                    editText.setMargin(viewsPadding);
                }

                if (textSize != -1) {
                    editText.setTextSize(dp2px(textSize));
                }

                if (hint != null && hint.length() > 0) {
                    editText.setHint(hint.substring(0, 1));
                }
                addView(editText);
            }
            getChildAt(0).requestFocus();
        }

        public void setViewsMargins(InputEditText editText, int margin) {
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.setMargins(margin, margin, margin, margin);
            editText.setLayoutParams(params);
        }

        private void clearLayout() {
            removeAllViewsInLayout();
        }

        public void onBackPressed(InputEditText view) {
            InputEditText child = (InputEditText) getChildAt(view.getOrder() - 1);
            if (child != null) {
                child.setText("");
                child.requestFocus();
            }
        }

        public void onKeyPressed(InputEditText view) {
            InputEditText child = (InputEditText) getChildAt(view.getOrder() + 1);
            if (child != null) {
                child.requestFocus();
            } else {
               /* InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                }*/
               new InputKeyboard(getContext());
                requestFocus();
                if (listener != null) {
                    listener.otpFinished(getOtp());
                }
            }
        }

        public InputView setListener(InputListener listener) {
            this.listener = listener;
            return this;
        }

        public InputView setOtp(String otp) {
            if (otp != null)
                for (int i = 0; i < otp.length(); i++) {
                    InputEditText child = (InputEditText) getChildAt(i);
                    String a = String.valueOf(otp.toCharArray()[i]);
                    child.setText(a);
                }
            return this;
        }

        public String getOtp() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < getChildCount(); i++) {
                InputEditText child = (InputEditText) getChildAt(i);
                builder.append(child.getText().toString());
            }
            return builder.toString();
        }

        private float dp2px(int dip) {
            float scale = getContext().getResources().getDisplayMetrics().density;
            return dip * scale + 0.5f;
        }

        public void focusChange(View view) {
            InputEditText editText = (InputEditText) view;
            if (editText.getOrder() < getOtp().length() - 1) {
                setFocus();
                /*InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.toggleSoftInputFromWindow(getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                }*/
            }
        }

        public InputView setFocus() {
            View view = getChildAt(getOtp().length());
            if (view != null) {
                view.requestFocus();
            } else {
                view = getChildAt(getChildCount() - 1);
                view.requestFocus();
            }
            return this;
        }
    }

