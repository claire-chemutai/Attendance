package com.app.study.attendanceproject;

/**
 * Created by study on 3/20/2019.
 */

public class Account {
    String  _nameText,_emailText, _mobileText,_passwordText,_reEnterPasswordText;

    public Account(){

    }

    public Account(String _nameText,  String _emailText,
                   String _mobileText, String _passwordText, String _reEnterPasswordText) {
        this._nameText = _nameText;
        this._emailText = _emailText;
        this._mobileText = _mobileText;
        this._passwordText = _passwordText;
        this._reEnterPasswordText = _reEnterPasswordText;
    }

    public String get_nameText() {
        return _nameText;
    }

    public void set_nameText(String _nameText) {
        this._nameText = _nameText;
    }



    public String get_emailText() {
        return _emailText;
    }

    public void set_emailText(String _emailText) {
        this._emailText = _emailText;
    }

    public String get_mobileText() {
        return _mobileText;
    }

    public void set_mobileText(String _mobileText) {
        this._mobileText = _mobileText;
    }

    public String get_passwordText() {
        return _passwordText;
    }

    public void set_passwordText(String _passwordText) {
        this._passwordText = _passwordText;
    }

    public String get_reEnterPasswordText() {
        return _reEnterPasswordText;
    }

    public void set_reEnterPasswordText(String _reEnterPasswordText) {
        this._reEnterPasswordText = _reEnterPasswordText;
    }
}
