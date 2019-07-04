import React, { Component } from 'react';
// import { Link } from 'react-router-dom';
import './inquiry.css'

let counter=0;
function createData(name, author, price, isbn, stock, img) {
	counter += 1;
	return { id: counter, name, author, price, isbn, stock, img };
}

class Shopcart extends Component {
    constructor(props) {
		super(props);
		this.state = {
			books: [
				createData('The Three-Body Problem', '	Liu Cixin', 4000, '‎278-3-16-148410-0', 7, './img/tb.jpg'),
			],
		};
	}

    render(){
        return(
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <td className="btn_login">书名</td>
                            <td className="btn_login" align="right">作者</td>
                            <td className="btn_login" align="right">价格</td>
                            <td className="btn_login" align="right">ISBN</td>
                            <td className="btn_login" align="right">库存</td>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.books.map((item, index) => {
                            return (
                                <tr key={index} >
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
                                    <td align="right">
                                        {item.stock}
                                    </td>
                                    <td align="right">
                                        {/* <Link to={this.handleLink(index)}>查看详情</Link> */}
                                    </td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default Shopcart;