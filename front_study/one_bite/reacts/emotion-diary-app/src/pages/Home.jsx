import {useSearchParams} from "react-router-dom";

function Home() {

    const [params, setParams] = useSearchParams();
    return (
        <div>Home - {params.get('val')}</div>
    )
}
export default Home;