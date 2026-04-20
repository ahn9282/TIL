import './TodoItem.css'
import {memo, useContext} from 'react';
import { TodoFuncContext } from "../App.jsx";

const TodoItem = ({id, isDone, content, date}) => {

    const {onUpdate, onDelete} = useContext(TodoFuncContext);
    const onChangeCheckBox = () => {
        onUpdate(id);
    };

    const onClickDelete = () => {
        onDelete(id);
    }

    return (
        <div className='TodoItem'>
            <input onChange={onChangeCheckBox} type="checkbox" checked={isDone}/>
            <div className='content'> {content} </div>
            <div className='date'> {new Date(date).toLocaleDateString()} </div>
            <button type='button' onClick={onClickDelete}>삭제</button>
            '
        </div>
    )
}
export default memo(TodoItem);
/*

export default memo(TodoItem, (prevProps, nextProps) => {
     //반환 값에 따라 Props가 변경을 판단
    //true => props 미변경 -> 리랜더링 x
    // false => props 변경 -> 리랜더링 o
    if (prevProps.id !== nextProps.id) return false;
    if (prevProps.isDone !== nextProps.isDone) return false;
    if (prevProps.content !== nextProps.content) return false;
    if (prevProps.date !== nextProps.date) return false;
    return true;
});
*/
