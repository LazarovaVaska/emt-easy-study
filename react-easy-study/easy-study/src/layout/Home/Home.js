import React, {Component} from 'react';
import {Animated} from "react-animated-css";
import "./Home.css";
import AdsService from "../../services/AdsService";
import PublicAdsList from './../../components/Ads/PublicAdsList/PublicAdsList'
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader
import {Carousel} from 'react-responsive-carousel';


class Home extends Component {
    state = {
        showTitle: true,
        ads: []
    };

    changeShowTitle = () => {
        this.setState({showTitle: false});
    };

    loadAds = () => {
        AdsService.getAllPublicAds()
            .then((data) => {
                this.setState({ads: data.data})
            }).catch((error) => error.message)
    }

    // carousel = () => {
    //     return (
    // <Carousel>
    //     <div>
    //         <img alt='pic1' src="https://images.unsplash.com/photo-1611252871536-305c663777ab?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTF8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60" />
    //         <p className="legend">Register or Login Here!</p>
    //     </div>
    //     <div>
    //         <img alt='pic2' src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.teachhub.com%2Fteaching-strategies%2F2016%2F08%2F5-essential-21st-century-teaching-strategies%2F&psig=AOvVaw11S0JsfEgKXjBUc2MTL0FA&ust=1632233069677000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCNDatpbcjfMCFQAAAAAdAAAAABAJ" />
    //         <p className="legend">Looking for a personal teacher? Find your ad here!</p>
    //     </div>
    //     <div>
    //         <img alt='pic3' src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.telegraph.co.uk%2Flifestyle%2Fget-into-teaching%2Flearning-from-students%2F&psig=AOvVaw11S0JsfEgKXjBUc2MTL0FA&ust=1632233069677000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCNDatpbcjfMCFQAAAAAdAAAAABAD" />
    //         <p className="legend">Giving classes on a specific Subject? Create your ad here!</p>
    //     </div>
    // </Carousel>

    //         )
    //
    // }

    render() {
        return (
            <main>
                {this.state.showTitle ?
                    <Animated animationIn="bounce" isVisible={true}>
                        <div className="Home-Title-Wrapper">
                            <h1 className="Home-Title">Welcome to EasyStudy!</h1>
                        </div>
                    </Animated> :
                    <div id='publicAdContent'>
                        <PublicAdsList ads={this.state.ads}/>
                    </div>
                }
            </main>
        )

    }

    componentDidMount() {
        setTimeout(() => this.changeShowTitle(), 1500);
        this.loadAds();

    }
};

export default Home;