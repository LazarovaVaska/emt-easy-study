import axios from '../axios/axios';

const path = '/ad'
const AdsService = {
    getAllPublicAds: () => {
        return axios.get(`${path}`)
    },
    getById: (id) => {
        return axios.get(`${path}/${id}`)
    },
    getCurrencies: () => {
        return axios.get(`${this.path}/currencies`)
    },
    createAd: (name, currency, amount) => {
        return axios.post(`${this.path}`, {
            name: name,
            price: {
                currency: currency,
                amount: amount
            }
        })
    }
};

export default AdsService;