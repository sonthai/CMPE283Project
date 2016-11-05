import React from "react";

export default class Greeting extends React.Component {
    render() {
	return (
	    <div className="btn btn-primary">
		Hello, {this.props.name}!
	    </div>
	);
    }
}
