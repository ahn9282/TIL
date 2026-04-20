import './Header.css';
import {memo} from 'react';

const Header = () => {
    return(
    <section className="Header">
        <h3>오늘은 📆</h3>
        <h1>{new Date().toDateString()}</h1>
    </section>
    );
}

export default memo(Header);