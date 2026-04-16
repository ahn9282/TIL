import './App.css'
import Header from "./components/Header.jsx";
import Editor from "./components/Editor.jsx";
import List from "./components/List.jsx";
import {useState, useRef} from "react";

const createMockData = function(id, isDone, content, date) {
    return {
        id: id,
        isDone: isDone,
        content: content,
        date: date
    };
}

function App() {
    const mockData = [
        createMockData(0, false, "React 공부하기", new Date().getTime()),
        createMockData(1, false, "빨래하기", new Date().getTime()),
        createMockData(2, false, "노래 연습하기", new Date().getTime()),
    ];
    const [todos, setTodos]  = useState(mockData);
    const idRef = useRef(3);

    const onCreate = (content) => {
        const newTodo = createMockData(idRef.current++, false, content, new Date().getTime())
        setTodos([newTodo, ...todos]);
    }

    const onUpdate = (targetId)=>{
        setTodos(todos.map((todo) => {
            if (todo.id === targetId) {
                return {
                    ...todo,
                    isDone: !todo.isDone
                }
            }
            return todo
        }))
    }

    const onDelete = (targetId) => {
        setTodos(todos.filter((todo) => todo.id !== targetId));
    }

  return (
    <div className="App">
      <Header />
      <Editor onCreate={onCreate}/>
      <List todos={todos} onUpdate={onUpdate} onDelete={onDelete}/>
    </div>
  )
}

export default App
