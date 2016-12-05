import React from "react";
import NavLink from './NavLink';
import { browserHistory } from 'react-router';

export default class Login extends React.Component {

    constructor() {
        super();
        this.state = {
            status: ''
        };
    }
    login(e, status) {


        /*if (status == 0) {
            alert("Login successful " + status);

        } else {
            alert("Login failed " + status);
        }*/

    }
    handleChange(e) {
        this.setState({status: e.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        const userName = event.target.elements[0].value;
        const repo = event.target.elements[1].value;
        const path = `/dashboard`;
        alert(path);
        browserHistory.push(path);
    }
    render() {
        return (
            <div className="container page-form">
                <form id="login-form" action="/auth/login" method="post">
                    <div className="form-group">
                        <label htmlFor="account">Account</label>
                        <input type="text" id="account" className="form-control" name="account"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input type="password" id="password" className="form-control" name="password"/>
                    </div>

                    <button type="submit" className="btn btn-success">Log in</button>
                    <br/>
                    <a href="/register" className="btn btn-success">Register</a>
                </form>
            </div>
        );
    }

}
