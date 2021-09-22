import React, {Fragment} from 'react';
import {Route, Switch} from 'react-router-dom';

import Home from '../layout/Home/Home';
import NotFound from '../layout/NotFound/NotFound';
import PublicAdsList from '../components/Ads/PublicAdsList/PublicAdsList'
import AdCreate from '../components/Ads/AdCreate/AdCreate'
import AdEdit from '../components/Ads/AdEdit/AdEdit'

const Routes = () => {
    return (
        // <Fragment>
        <Switch>
            <Route path="/"><Home/></Route>
            <Route path="/home"><Home/></Route>
            <Route path="/ads"><PublicAdsList/></Route>
            <Route path="/ads/create" component={AdCreate} exact/>
            <Route path="/ads/:id/edit" component={AdEdit} exact/>
            <Route component={NotFound} exact/>
        </Switch>
        // </Fragment>
    );
};

export default Routes;