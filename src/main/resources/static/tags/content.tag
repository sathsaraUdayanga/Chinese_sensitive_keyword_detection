<content>
    <popup></popup>
    <header>
        <h1>Chinese Sensitive Keywords Detection</h1>
    </header>
    <div contenteditable="true" id="cnt" ref="search" class="column">
        web page content here …
    </div>

    <button onclick ={search} class="button">Submit</button>
    <button class="button" onclick={functionAlert}>Focus</button>

    <script>
        this.on('mount',function(){
            this.refs.search.focus()
        });

        this.search = function(e){
            e.preventDefault();
            let content = document.getElementById("cnt").innerHTML;
            this.apiSerach(content)
            button.scrollIntoView();
        };

        var i=0;
        var findNext = function(){
            var spans = document.getElementsByClassName('highlight');
            if(i==0){
                spans[spans.length-1].classList.remove("select")
            }else{
                spans[i-1].classList.remove("select")
            }

            spans[i].classList.add("select");
            spans[i].scrollIntoView();
            i += 1;
            i = i % spans.length
        }

        //Function for popup box
        this.functionAlert = function(msg, myYes) {
            findNext();
            var confirmBox = $("#confirm");
            confirmBox.find(".next").click(function() {
                findNext();
            });

            confirmBox.find(".close").click(function() {
                confirmBox.hide();
            });
            confirmBox.show();
        }
    </script>
</content>