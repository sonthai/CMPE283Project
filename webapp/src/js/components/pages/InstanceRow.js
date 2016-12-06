import React from 'react';
import styles from './../../styles/dashboard.css';

export default class InstanceRow extends React.Component {
    handleReserve() {
        alert("Release");
    }
    handleRelease() {

    }
    handleResume() {

    }

    handleSuspend() {

    }
    render() {
        var usage =  4;
        var cost = 120;
        return (
            <tr className="even gradeC">
                <td>{this.props.instance.projectName}</td>
                <td>{usage}</td>
                <td>$ {cost}</td>
                <td className="center">
                    <button type="button" className="btn btn-info btn-xs" onClick={this.handleReserve}>Reserve</button>
                    <button type="button" className="btn btn-info btn-xs" onClick={this.handleRelease}>Release</button>
                    <button type="button" className="btn btn-info btn-xs" onClick={this.handleSuspend}>Suspend</button>
                    <button type="button" className="btn btn-info btn-xs" onClick={this.handleResume}>Resume</button>
                </td>
            </tr>
        );
    }
}