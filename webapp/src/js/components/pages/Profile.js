import React from 'react';
import { Link } from 'react-router';

export default class Profile extends React.Component {
    render() {
        return (
           <div className="skin-black">
                <div className="wrapper row-offcanvas row-offcanvas-left">
                    <aside className="left-side sidebar-offcanvas">
                        <section className="sidebar">
                            <ul className="sidebar-menu">
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
                        </section>
                    </aside>
                    <aside className="right-side">
                        <section className="content">
                            <div className="row">
                                <div className="col-md-12">
                                    <section className="panel">
                                        <header className="panel-heading">
                                            Profile Information
                                        </header>
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
                                    </section>
                                </div>
                            </div>
                        </section>
                    </aside>
                 </div>
            </div>
        );
    }
}