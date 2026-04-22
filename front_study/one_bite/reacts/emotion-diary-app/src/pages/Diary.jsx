import {useParams} from 'react-router-dom'

export const Diary = () => {
    const params = useParams();
    return (
        <div>Diary No.{params.id}</div>
    )
}
export default Diary;