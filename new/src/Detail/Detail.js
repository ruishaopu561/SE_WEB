import React, { Component } from 'react';
import pic from '../image/2.jpeg';
import './detail.css';

let counter = 0;
function createData(name, author, price, isbn, stock, img) {
    counter += 1;
    return { id: counter, name, author, price, isbn, stock, img };
}
class Detail extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [
                createData('Harry Potter', ' J. K. Rowling', 3000, '‎978-3-16-148410-0', 5, './img/hp.jpg'),
                createData('King of the Ring', 'John Ronald Reuel Tolkien', 5000, '‎178-3-16-148410-0', 9, './img/ring.jpg'),
                createData('The Three-Body Problem', '	Liu Cixin', 4000, '‎278-3-16-148410-0', 7, './img/tb.jpg'),
            ]
        };
    }
    render() {
        return (
            <div className="paper">
                <img src={pic} alt="book" width="320" height="480"/>
                <table className="table">
                    <thead>
                        <tr>
                            <td >书名</td>
                            <td align="right">作者</td>
                            <td align="right">价格</td>
                            <td align="right">isbn</td>
                            <td align="right">库存</td>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.books.map((item, index) => {
                            if (index === this.props.match.params.id) {
                                return (
                                    <tr key={index}>
                                        <td component="th">
                                            {item.name}
                                        </td>
                                        <td align="right">
                                            {item.author}
                                        </td>
                                        <td align="right">
                                            {item.price / 100}
                                        </td>
                                        <td align="right">
                                            {item.isbn}
                                        </td>
                                        <td align="right" >
                                            {item.stock}
                                        </td>
                                    </tr>
                                )
                            }
                            else{
                                return null;
                            }
                        })}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default Detail;

// class Detail extends Component {
//     constructor(){
//         super(...arguments);
//         this.state={
//             hover: false,
//         }
//         this.onMouseEnter = this.onMouseEnter.bind(this);
//         this.onMouseLeave = this.onMouseLeave.bind(this);
//     }

//     onMouseEnter(){
//         this.setState({
//             hover:true,
//         })
//     }

//     onMouseLeave(){
//         this.setState({
//             hover:false,
//         })
//     }

//     render(){
//         return(
//             <div className="introduce">
//                 <div className="show">
//                     <img className="sample" src={pic} alt="Sample"/>
//                     <p className="book-name">xxxx</p>
//                     <p>price:$xxx</p>
//                 </div>
//                 <div className="inputText">
//                     <input className="text" type="text" defaultValue="Introduction"/>
//                 </div>
//             </div>
//         )
//     }
// }

// export default Detail;