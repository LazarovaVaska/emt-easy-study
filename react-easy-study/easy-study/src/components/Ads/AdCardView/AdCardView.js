import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import AdEdit from "../AdEdit/AdEdit";
import AdsService from "../../../services/AdsService";

class AdCardView extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            this.props.ads.map((ad) => {
                return <div className="card">
                    <div className="top">
                        <div className="title-card">
                            <p>{ad.name}</p>
                        </div>
                    </div>
                    <div className="bottom">
                        <h2>Money</h2>
                        <h3>{ad.amount}</h3>
                        <p>{ad.currency}</p>
                        <Link className={"btn btn-block btn-dark"}
                              to={<AdEdit ad={ad} currencies={this.props.currencies}
                                          onEditAd={this.editAd}/>}>Edit</Link>
                        <a className="btn" href="#">Subscribe</a>
                    </div>
                </div>
            })
        );
    }

    editAd = (name, currency, amount) => {
        AdsService.createAd(name, currency, amount)
            .then(() => {
                this.loadAds();
            }).catch((error) => console.log(error.message))
    }
};

export default AdCardView;