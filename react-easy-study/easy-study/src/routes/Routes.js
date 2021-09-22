import React, {Fragment} from 'react';
import {Route, Switch} from 'react-router-dom';

import Home from '../layout/Home/Home';
import NotFound from '../layout/NotFound/NotFound';
// import NewPost from '../components/NewPost/NewPost';
// import Posts from '../components/Posts/Posts';
// import FullPost from '../components/FullPost/FullPost';

const Routes = () => {
    return (
        // <Fragment>
        <Switch>
            <Route path="/"><Home/></Route>
            <Route path="/home"><Home/></Route>
            <Route path="/ads"></Route>
            {/*<Route path="/posts" component={Posts} exact/>*/}
            {/*<Route path="/post/:postTitle" component={FullPost} exact/>*/}
            <Route component={NotFound} exact/>
        </Switch>
        // </Fragment>
    );
};

export default Routes;