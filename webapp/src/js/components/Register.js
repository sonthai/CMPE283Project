import React from "react";
import NavLink from './NavLink';
import { browserHistory } from 'react-router';

export default class Register extends React.Component {

    constructor() {
        super();
        this.state = {
            status: ''
        };
    }
    register(e, status) {


        /*if (status == 0) {
            alert("Register successful " + status);

        } else {
            alert("Register failed " + status);
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
        //alert(path);
        browserHistory.push(path);
    }
    render() {
        return (
            <div className="container page-form">
                <form id="register-form" action="/auth/register" method="post">
                    <div className="form-group">
                        <label htmlFor="account">Account</label>
                        <input type="text" id="account" className="form-control" name="account"/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password</label>
                        <input type="password" id="password" className="form-control" name="password"/>
                    </div>

                    <div className="form-group">
                        <label htmlFor="first_name">First Name</label>
                        <input type="text" id="first_name" className="form-control" name="first_name"/>
                    </div>

                    <div className="form-group">
                        <label htmlFor="last_name">Last Name</label>
                        <input type="text" id="last_name" className="form-control" name="last_name"/>
                    </div>

                    <div className="form-group">
                        <label htmlFor="role">Role</label>
                        <input type="text" id="role" className="form-control" name="role"/>
                    </div>
                    <button type="submit" className="btn btn-success">Sign up</button>
                </form>
            </div>
        );
    }

}
