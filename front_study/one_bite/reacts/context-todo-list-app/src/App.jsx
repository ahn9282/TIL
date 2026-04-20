import './App.css'
import Header from "./components/Header.jsx";
import Editor from "./components/Editor.jsx";
import List from "./components/List.jsx";
import {useReducer, useRef, useCallback} from "react";
import Exam from "./components/Exam.jsx";

const createMockData = function (id, isDone, content, date) {
    return {
        id: id,
        isDone: isDone,
        content: content,
        date: date
    };
}

const reduce = function (state, action) {
    switch (action.type) {
        case "CREATE":
            return [...state, action.data];
        case "UPDATE":
            return state.map((item) => {
                if (item.id === action.data) {
                    return {...item, isDone: !item.isDone}
                }
                return item
            })
        case "DELETE":
            return state.filter((item) => item.id !== action.data);
        default:
            return state;
    }
}

function App() {
    const mockData = [
        createMockData(0, false, "React 공부하기", new Date().getTime()),
        createMockData(1, false, "빨래하기", new Date().getTime()),
        createMockData(2, false, "노래 연습하기", new Date().getTime()),
    ];
    const [todos, dispatch] = useReducer(reduce, mockData);
    const idRef = useRef(3);
    const callTodoDispatch = function (type, data) {
        return dispatch({
            type: type,
            data: data
        })
    }

    const onCreate = useCallback((content) => {
        callTodoDispatch("CREATE", createMockData(idRef.current++, false, content, new Date().getTime()));
    }, []);

    const onUpdate = useCallback((targetId) => {
        callTodoDispatch("UPDATE", targetId);
    }, []);

    const onDelete = useCallback((targetId) => {
        callTodoDispatch("DELETE", targetId);
    }, []);


    return (
        <div className="App">
            <Exam/>
            <Header/>
            <Editor onCreate={onCreate}/>
            <List todos={todos} onUpdate={onUpdate} onDelete={onDelete}/>
        </div>
    )
}

export default App
