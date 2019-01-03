<results>
    <p>Keywords found:</p>
    <p if={f==0}>No results found</p>
    <pre each={r in results}>  <span style="color: red">{r}</span> </pre>

    <script>
        f = 1;
        this.api.on('complete',function(res){
            results = res.keywords;
            if (res.found==0){
                f=0;
            }else{
                f=1;
                document.getElementById("cnt").innerHTML = res.htmlContent
            }
            riot.update()
        })
    </script>
</results>