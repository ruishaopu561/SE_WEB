import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import './inquiry.css';

let counter = 0;
function createData(name, author, price, isbn, stock, img) {
	counter += 1;
	return { id: counter, name, author, price, isbn, stock, img };
}

class ManageBook extends Component {
    constructor(props){
        super(props);
        this.state={
            books: [
                createData('Harry Potter', ' J. K. Rowling', 3000, '‎978-3-16-148410-0', 5, './img/hp.jpg'),
                createData('King of the Ring', 'John Ronald Reuel Tolkien', 5000, '‎178-3-16-148410-0', 9, './img/ring.jpg'),
                createData('The Three-Body Problem', '	Liu Cixin', 4000, '‎278-3-16-148410-0', 7, './img/tb.jpg'),
            ],
            booksCp: [
                createData('Harry Potter', ' J. K. Rowling', 3000, '‎978-3-16-148410-0', 5, './img/hp.jpg'),
                createData('King of the Ring', 'John Ronald Reuel Tolkien', 5000, '‎178-3-16-148410-0', 9, './img/ring.jpg'),
                createData('The Three-Body Problem', '	Liu Cixin', 4000, '‎278-3-16-148410-0', 7, './img/tb.jpg'),
            ],
            value:[]
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event)
    {
        let item = event.target.value;
        let items = this.state.value.slice();
        let index = items.indexOf(item);
        index === -1 ? items.push(item) : items.splice(index, 1);
        this.setState({value: items})
    }

    render() {
        return (
            <div>
                <div>
                    <table>
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
                                    <td align="right" >
                                        {item.stock}
                                    </td>
                                    <td align="right" >
                                        {/* <Link to={this.handleLink(index)}>查看详情</Link> */}
                                    </td>
                                </tr>
                            )
                        })}
                        </tbody>
                    </table>
                </div>
                <div>
                    <div>
                        <button className="manage">
                            新建
                        </button>
                    </div>
                    <div>
                        <button className="manage">
                            删除
                        </button>
                    </div>
                    <div>
                        <button className="manage">
                            修改
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

export default ManageBook;