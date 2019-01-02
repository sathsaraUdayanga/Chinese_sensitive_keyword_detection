<results>
    <p>Keywords found:</p>
    <p if={r==0}>No results found</p>
    <pre each={results}>  <span style="color: red">{text}</span>      At index:{id} Length:{length}</pre>
    <script>
        results=[];
        r=1;
        this.api.on('complete',function(res){
            results = res;
            r=results.length;
            riot.update()
        })

    </script>
</results>