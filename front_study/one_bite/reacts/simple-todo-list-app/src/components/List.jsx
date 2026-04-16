import './List.css'
import TodoItem from "./TodoItem.jsx";
import {useState} from "react";

const List = ({todos, onUpdate, onDelete}) => {

    const [search, setSearch] = useState("");

    const onChangeSearch = function(e) {
        setSearch(e.target.value);
    }
    const getFilteredDate = () => {

        if (search === "") return todos;
        return todos.filter((todo) => todo.content.toLowerCase().includes(search.toLowerCase()));
    }

    const filteredTodos = getFilteredDate();

    return (
        <section className="List">
            <h4>Todo List 🌱</h4>
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