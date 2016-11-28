import React from 'react';
import { Link } from 'react-router';
import styles from './../../styles/customUI.css';


export default class Project extends React.Component {
    handleSubmit() {

    }
    render() {
        return (
            <div className="container">
                <h1>Project</h1>
                <div className="row">
                    <div className="col-sm-4">
                        <ul className="nav nav-pills nav-stacked">
                          <li role="presentation" className="btn-success"><Link to="dashboard"><a href="#">DashBoard</a></Link></li>
                          <li class="active btn-success"><Link to="project"><a href="#">Project</a></Link></li>
                          <li className="btn-success"><Link to="profile"><a href="#">Profile</a></Link></li>
                        </ul>
                    </div>
                    <div className="col-sm-8">
                        <form onSubmit={this.handleSubmit}>
                             <div className="form-group row">
                               <label for="project-name" class="col-xs-2 col-form-label">Project Name</label>
                               <div class="col-xs-10">
                                 <input className="form-control" type="text" id="project-name-input"/>
                               </div>
                             </div>
                             <div className="form-group row">
                                 <label for="instance-image">Image</label>
                                 <select className="form-control" id="image">
                                   <option>Ubuntu</option>
                                   <option>MacOS</option>
                                   <option>Windows</option>
                                 </select>
                             </div>
                             <button className="btn btn-primary" type="submit">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}