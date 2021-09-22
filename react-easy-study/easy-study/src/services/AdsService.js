import axios from '../axios/axios';

const path = '/resources'
const AdsService = {
    getAllPublicAds: () => {
        return axios.get(`${path}/public`)
    },
    test: () =>{
        return axios.get(`${path}/test`)
    }
};

export default AdsService;