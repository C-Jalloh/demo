import React from 'react';

class NewVideo extends React.Component {

    constructor(props) {
    super(props)
    this.state = {
        name: ''
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);

    }
    handleChange(event) {
    this.setState({name: event.target.value});
    }

    async handleSubmit(event){
        event.preventDefault();
        await fetch('/api/videos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name: this.state.name})
        }).then(response => 
            window.location.href = "react"
        ) }
        
        render() {
            return (
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Name:
                        <input type="text" value={this.state.name} onChange={this.handleChange} />
                    </label>
                    <input type="submit" value="Submit" />
                </form>
            );
        }
        
    }
export default NewVideo;