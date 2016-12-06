import React from 'react';
import { Link } from 'react-router';
import styles from './../../styles/dashboard.css';

export default class Profile extends React.Component {
    render() {
        return (
         <div className="wrapper">
            <nav className="navbar navbar-default navbar-static-top no-margin-bottom" role="navigation">
                <div className="navbar-header">
                    <button type="button" className="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span className="sr-only">Toggle navigation</span>
                        <span className="icon-bar"></span>
                        <span className="icon-bar"></span>
                        <span className="icon-bar"></span>
                    </button>
                    <a className="navbar-brand" href="index.html">ZenWS - Logged in as "Test User"</a>
                </div>

                <div className="navbar-default sidebar" role="navigation">
                    <div className="sidebar-nav navbar-collapse">
                        <ul className="nav" id="side-menu">
                           <li>
                            <Link to="dashboard">Dashboard</Link>
                           </li>
                           <li>
                            <Link to="project">Project</Link>
                           </li>
                           <li>
                            <Link to="profile">Profile</Link>
                           </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div id="page-wrapper">
                <div className="row">
                    <div className="col-lg-12">
                        <h1 className="page-header">Project Description</h1>
                    </div>
                </div>
                <div className="row">
                     <div className="panel-body">
                        <form className="form-horizontal tasi-form">
                             <div className="form-group">
                                <label htmlFor="first-name" className="col-sm-2 col-sm-2 control-label">First Name</label>
                                <div className="col-xs-4">
                                    <input id="first" className="form-control" type="text" disable="true "value="Son" />
                                </div>
                             </div>
                             <div className="form-group">
                                 <label htmlFor="last-name" className="col-sm-2 col-sm-2 control-label">Last Name</label>
                                 <div className="col-xs-4">
                                    <input id="first" className="form-control" type="text" disable="true"/>
                                 </div>
                              </div>
                              <div className="form-group">
                                  <label htmlFor="username" className="col-sm-2 col-sm-2 control-label">UserName</label>
                                  <div className="col-xs-4">
                                      <input id="username" className="form-control" type="text" disable="true"/>
                                  </div>
                               </div>
                               <div className="form-group">
                                   <label htmlFor="Password" className="col-sm-2 col-sm-2 control-label">Password</label>
                                   <div className="col-xs-4">
                                       <input id="password" className="form-control" type="password" disable="true" />
                                   </div>
                              </div>
                               <div className="form-group">
                                    <label htmlFor="email" className="col-sm-2 col-sm-2 control-label">Email</label>
                                    <div className="col-xs-4">
                                        <input id="email" className="form-control" type="text" disable="true" />
                                    </div>
                               </div>
                               <div className="form-group">
                                    <label htmlFor="Address" className="col-sm-2 col-sm-2 control-label">Address</label>
                                    <div className="col-xs-4">
                                        <input id="address" className="form-control" type="text" disable="true" />
                                    </div>
                               </div>
                               <div className="form-group">
                                   <label htmlFor="Phone Number" className="col-sm-2 col-sm-2 control-label">Phone No</label>
                                   <div className="col-xs-4">
                                       <input id="phoneNo" className="form-control" type="text" disable="true" />
                                   </div>
                              </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        );
    }
}