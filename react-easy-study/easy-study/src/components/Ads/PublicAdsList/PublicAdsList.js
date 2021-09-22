import React, {Component} from 'react';
import AdCardView from './../AdCardView/AdCardView'
import './PublicAdsList.css'

class PublicAdsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 4
        }
    }

    render() {
        return (
            <div>public asdsad</div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getAdsPage = (offset, nextPageOffset) => {
        return this.props.products.map((term, index) => {
            return (
                <AdCardView term={term} onDelete={this.props.onDelete} onEdit={this.props.onEdit}/>
            );
        }).filter((product, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }

};

export default PublicAdsList;