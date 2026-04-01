import Button from '/src/components/Button'
import Header from '/src/components/Header'


const App = () => {

    const buttonProps = {
        text: "메일",
        color: "orange",
        a : 1,
        b : 2,
        c : 3,
    }

  return (
    <main>
        <Button {...buttonProps} />
        <Button text="버튼 2" color="green" >
            <Header />
        </Button>
        <Button text="버튼 3" color="red" >
            <div>자식 요소</div>
        </Button>
        <Button text="버튼 4" />
    </main>
  );
}

export default App