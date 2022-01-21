import React from "react";
import { signup } from './../api/ApiCalls'

class UserSignupPage extends React.Component {

    state = {
        userName: null,
        displayName: null,
        password: null,
        rePassword: null,
        pendingApiCall: false
    }

    onChange = e => {

        const { name, value } = e.target;

        this.setState({
            [name]: value
        })
    }

    onClickSignUp = async e => {
        e.preventDefault();
        const { userName, displayName, password } = this.state;
        const body = {
            userName,
            displayName,
            password
        }

        this.setState({ pendingApiCall: true })

        try {
            const res = await signup(body)
        }catch(err) {

        }

        this.setState( { pendingApiCall: false})
        

        // signup(body)
        //     .then((res) => {
        //         this.setState({ pendingApiCall: false })
        //     })
        //     .catch((err) => {
        //         this.setState({ pendingApiCall: false })
        //     })

    }


    render() {
        const { pendingApiCall } = this.state;
        return (
            <div className="container">
                <div className="row justify-content-center">
                    <div className="form-group col-md-4 col-md-offset-5 align-center ">
                        <form>
                            <h1 className="text-center">Sign Up</h1>
                            <div className="form-group">
                                <label>Username</label>
                                <input className="form-control" name="userName" onChange={this.onChange} />
                            </div>
                            <br></br>
                            <div className="form-group">
                                <label>Display Name</label>
                                <input className="form-control" name="displayName" onChange={this.onChange} />
                            </div>
                            <br></br>
                            <div className="form-group">
                                <label>Password</label>
                                <input className="form-control" name="password" type="password" onChange={this.onChange} />
                            </div>
                            <br></br>
                            <div className="form-group">
                                <label>Password Repeat</label>
                                <input className="form-control" name="rePassword" type="password" onChange={this.onChange} />
                            </div>
                            <br></br>
                            <button
                                type="button"
                                className="btn btn-primary"
                                disabled={pendingApiCall}
                                onClick={this.onClickSignUp}>
                                {pendingApiCall && <span className="spinner-grow spinner-grow-sm text-light"></span>}
                                Sign Up
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}


export default UserSignupPage;