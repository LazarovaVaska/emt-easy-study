import React, {Component} from 'react';
import ReactPaginate from 'react-paginate'
import {Link} from 'react-router-dom';
import AdCardView from './../AdCardView/AdCardView'
import './PublicAdsList.css'
import AdCreate from "../AdCreate/AdCreate";
import AdsService from "../../../services/AdsService";

class PublicAdsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 4,
            currencies: []
        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.ads.length / this.state.size);
        const ads = this.getAdsPage(offset, nextPageOffset);


        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <tbody>
                            {ads}
                            </tbody>
                        </table>
                    </div>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={<AdCreate onAddAd={this.addAd}/>}>Add new
                                    Ad</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <ReactPaginate previousLabel={"back"}
                               nextLabel={"next"}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getAdsPage = (offset, nextPageOffset) => {
        return this.props.ads.map((term, index) => {
            return (
                <AdCardView term={term} currencies={this.currencies} onDelete={this.props.onDelete}
                            onEdit={this.props.onEdit}/>
            );
        }).filter((ad, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }

    addAd = (name, currency, amount) => {
        AdsService.createAd(name, currency, amount)
            .then(() => {
                this.loadAds();
            }).catch((error) => console.log(error.message))
    }

    currencies = () => {
        AdsService.getCurrencies()
            .then(currencies => {
                this.setState({currencies: currencies})
            }).catch(err => console.log(err))
    }
};

export default PublicAdsList;