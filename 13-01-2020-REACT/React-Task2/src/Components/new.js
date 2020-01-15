import React from 'react';
import JsonData from "../data.json"
import { connect } from 'react-redux';

class New extends React.Component{
	 
	constructor(props){
      super(props);
      this.state = {
		    DataList: JsonData,
      }
	 }
	 
    handleCheck(save){
			this.props.saveUserDetails('userarr', save);
	}

	render() {
		let country = this.state.DataList;
	
		return ( 
				<div>
                <h1>REDUX ASSIGNMENT</h1>
                <div style={{
					'boxSizing' : "border-box",
					'width': "50%",
					'float':"left"}}>
                <table>
                    <tbody>
                    <th>Display Data</th><br/>
                    <tr>
                        <th>ID</th>
                        <th>STATE</th>
                        <th>CITY</th>
                   </tr>
				    {country.map((item, id1) => {
				    return (<tr key={id1} onClick={() => this.handleCheck(item)} >
                    <td>{item.id}</td>
                    <td>{item.state}</td>
                    <td>{item.city}</td>
                    </tr>)})}
                    </tbody>
                </table>
				</div>

				<div style={{
					'boxSizing' : "border-box",
					'width': "50%",
					'float':"left"}}>
                    <table>
                    <tbody>
                    <th>ONCLICK DISPLAY</th><br/>
                    <tr>
                        <th>ID</th>
                        <th>STATE</th>
                        <th>CITY</th>
                    </tr>
				    {this.props.arr.map((item, id1) => {
				    return (<tr  key={id1}  >
                    <td>{item.id}</td>
                    <td>{item.state}</td>
                    <td>{item.city}</td>
                    </tr>)})}
                </tbody>
                </table>
				</div>
			</div>
		)
      }     
}

const mapStateToProps = (state) => {
	return{
		arr: state.userarr,
	}
}

const mapDispatchToProps = (dispatch) => {
	return{
		saveUserDetails: (name, val) => {dispatch({type: 'ON_CLICK_DISPLAY', [name]: val})}
	}
}

export default connect(mapStateToProps, mapDispatchToProps)(New);