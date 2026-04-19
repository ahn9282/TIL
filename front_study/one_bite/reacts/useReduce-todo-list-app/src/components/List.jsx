import './List.css'
import TodoItem from "./TodoItem.jsx";
import {useState, useMemo} from "react";

const List = ({todos, onUpdate, onDelete}) => {

    const [search, setSearch] = useState("");

    const onChangeSearch = function(e) {
        setSearch(e.target.value);
    }
    const getFilteredDate = () => {

        if (search === "") return todos;
        return todos.filter((todo) => todo.content.toLowerCase().includes(search.toLowerCase()));
    }

/*
   const getAnalyzedData = () => {
        const totalCount = todos.length;
        const doneCount = todos.filter((todo) => todo.isDone).length;
        const notDoneCount = totalCount - doneCount;

        return {
            totalCount: totalCount,
            doneCount: doneCount,
            notDoneCount: notDoneCount,
        }
    };
    */

    const {totalCount, doneCount, notDoneCount} = useMemo(() => {
        const totalCount = todos.length;
        const doneCount = todos.filter((todo) => todo.isDone).length;
        const notDoneCount = totalCount - doneCount;

        console.log("useMemo");
        return {
            totalCount: totalCount,
            doneCount: doneCount,
            notDoneCount: notDoneCount,
        }
    }, [todos]);

    //의존성 배열 : deps

    const filteredTodos = getFilteredDate();
    //const {totalCount, doneCount, notDoneCount} = getAnalyzedData();

    return (
        <section className="List">
            <h4>Todo List 🌱</h4>
            <div>
                <div>total: {totalCount}</div>
                <div>done: {doneCount}</div>
                <div>notDone: {notDoneCount}</div>
            </div>
            <input placeholder="검색어를 입력하세요." value={search} onChange={onChangeSearch}/>
            <div className={"todos_wrapper"}>
                {filteredTodos.map((todo)=>{
                    return <TodoItem key={todo.id} {...todo} onUpdate={onUpdate} onDelete={onDelete}/>
                })}
            </div>
        </section>
    )
}
 export default List;