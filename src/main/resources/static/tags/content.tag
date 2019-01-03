<content>

    <div contenteditable="true" id="cnt" ref="search">
        web page content here …
    </div>

    <form onsubmit={search}>
        <fieldset>
            <input class="button-primary" type="submit">
        </fieldset>
    </form>

    <script>
        this.on('mount',function(){
            this.refs.search.focus()
        })

        this.search = function(e){
            e.preventDefault()
            let content = document.getElementById("cnt").innerHTML
            this.apiSerach(content)
        }
    </script>
</content>