const campos = document.querySelectorAll(" form input ");
const btns = document.querySelectorAll(" form button ");

console.log( campos );
console.log( btns );

const callAjax = (e) => {
    fetch(`http://localhost:8080/ajaxServlet?cpValor1=${campos[0].value}&cpValor2=${campos[1].value}&btns=${e.target.value}`,{
        method: "GET"
    }).then( async resp=>{
        const r = await resp.text();
        console.log(r);

        const out = document.querySelector("div-principal h3");
        out.innerHTML = `${campos[0].value} ${e.target.value} ${campos[1].value} = ${r}`;
        out.style.display = 'block';
        campos.forEach(c => c.value = "0");

    })
}

btns.forEach((b) => {
        b.addEventListener("Click", callAjax);
    });
