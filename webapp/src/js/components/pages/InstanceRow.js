import React from 'react';
import styles from './../../styles/dashboard.css';

export default class InstanceRow extends React.Component {
    handleReserve(status, e) {
        console.log(status);

    }
    handleRelease() {

    }
    handleResume() {

    }

    handleSuspend() {

    }
    render() {
        return (
            <tr className="even gradeC">
                <td>{this.props.instance.projectName}</td>
                <td>{this.props.instance.hourUsage} hour(s)</td>
                <td>{this.props.instance.status}</td>
                <td>{this.props.instance.dateCreated}</td>
                <td className="center">
                    <button type="button" className="btn btn-info btn-xs" onClick={this.handleReserve.bind(this, this.props.instance.status)}>Reserve</button>
                    <button type="button" className="btn btn-info btn-xs" onClick={this.handleRelease}>Release</button>
                    <button type="button" className="btn btn-info btn-xs" onClick={this.handleSuspend}>Suspend</button>
                    <button type="button" className="btn btn-info btn-xs" onClick={this.handleResume}>Resume</button>
                </td>
            </tr>
        );
    }
}