import React from 'react';
import {useHistory} from 'react-router-dom';

const AdEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        price: 0,
        currency: ""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.product.name;
        const price = formData.price !== 0 ? formData.price : props.product.price;
        const currency = formData.currency !== 0 ? formData.currency : props.ad.currency.id;

        props.onEditAd(props.ad.id, name, price, currency);
        history.push("/ads");
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Ad name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.ad.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Price</label>
                        <input type="text"
                               className="form-control"
                               id="price"
                               name="price"
                               placeholder={props.ad.price}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="currency" className="form-control" onChange={handleChange}>
                            {props.currencies.map((term) => {
                                if (props.ad.currency !== undefined &&
                                    props.ad.currency.id === term.id)
                                    return <option selected={props.ad.currency.id}
                                                   value={term.id}>{term.name}</option>
                                else return <option value={term.id}>{term.name}</option>
                            })}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
};

export default AdEdit;