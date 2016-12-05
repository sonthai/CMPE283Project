import React from 'react';
import { Link } from 'react-router';
import styles from './../../styles/customUI.css';


export default class Project extends React.Component {
    componentDidMount () {
        this.renderCalendar();
    }

    componentDidUpdate () {
        this.renderCalendar();
    }

    renderCalendar() {
        //$(this.refs.calenderView).datetimepicker();
    }

    handleSubmit() {

    }
    render() {
        return (
            <div className="wrappe">
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
				                            Project Description
				                        </header>
				                        <div className="panel-body">
                                            <form className="form-horizontal tasi-form" onSubmit={this.handleSubmit}>
                                                 <div className="form-group">
                                                    <label htmlFor="project-name" className="col-sm-2 col-sm-2 control-label">Project Name</label>
                                                    <div className="col-xs-4">
                                                        <input id="project-id" className="form-control" type="text" />
                                                    </div>
                                                 </div>
                                                 <div className="form-group">
                                                     <label htmlFor="image" className="col-sm-2 col-sm-2 control-label">Image</label>
                                                     <div className="col-xs-4">
                                                         <select id="image" className="form-control">
                                                            <option>Ubuntu</option>
                                                            <option>Mac OS</option>
                                                            <option>Window</option>
                                                         </select>
                                                     </div>
                                                  </div>
                                                  <div className="form-group">
                                                      <label htmlFor="flavor" className="col-sm-2 col-sm-2 control-label">Flavor</label>
                                                      <div className="col-xs-5">
                                                          <input id="flavor" className="form-control" type="text" />
                                                      </div>
                                                   </div>
                                                   <div className="form-group">
                                                        <label htmlFor="dateCreated" className="col-sm-2 col-sm-2 control-label">Created Date</label>
                                                        <div className="col-xs-5">
                                                            <div className="input-group date" ref="calendarView">
                                                                <input type="text" className="form-control"/>
                                                                <span className="input-group-addon">
                                                                    <span className="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                                            </div>
                                                        </div>
                                                   </div>
                                                   <div className="form-group">
                                                        <div className="col-lg-offset-2 col-lg-10">
                                                            <button className="btn btn-primary" type="submit">Submit</button>
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
