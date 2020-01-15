import React from 'react';
import jsonData from './data.json';
//import ReactDOM from 'react-dom';
class Demo extends React.Component
{
    constructor(){
        super();
          this.state = {
          people: jsonData,
          text: [],
          srch1: jsonData,
        }
    }

    search = srch => {
        console.log(srch.target.value);
        var r1 = new RegExp(srch.target.value);
        console.log(r1);
        var listt = this.state.people.filter((item)=> {
            //console.log(item);
            if(r1.test(item.city))
            {
                //console.log("aa"); 
                return item;
            }
               
        });
        //console.log(listt);
        this.setState({srch1:listt});
        console.log(this.state.srch1);

    }

    name = evt => {
        //console.log("hiii");
        //console.log(evt.target.innerText);
        var t1 = [];
        t1=this.state.text;
        t1.push(evt.target.innerText)
        console.log(t1);
        this.setState({text : t1});
        console.log(this.state.text);
        //alert(text);
        //ReactDOM.render(text,document.getElementById("root"));
    }


    
    render()
    {
        //const dt=jsonData;
        // const list=this.state.people.map((item)=>
        // <li key={item.id} onClick={this.name}>
        // {item.city}</li>
    //);    
        return (
            <div>

                <div style={{width:"30%",display:"block",float:"left",margin:"10%"}}>
                    <h3>Part 1....Clicking and Displaying</h3>
                    <ul>
                        {this.state.text.map((item)=>(<li key="item.id">{item}</li>))}
                    </ul>
                    <ul> 
                        {this.state.people.map((item)=>
                    <li key={item.id} onClick={this.name}>
                        {item.city}</li>)}
                    </ul>
                </div>

                <div style={{width:"30%",display:"block",float:"right",margin:"10%"}}>
                    <h3>Part2.......String Matching</h3>
                    <input type="text" id = "search" onChange={this.search}/>
                    <ul>
                        {this.state.srch1.map((item)=>(<li key="item.id">{item.id},{item.city},{item.state}</li>))}
                    </ul>
                </div>     

            </div>
        );
    }

}
export default Demo;