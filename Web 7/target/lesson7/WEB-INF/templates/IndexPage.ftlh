<#import "commons.ftlh" as c>

<@c.page>
    <div class="article">
        <template>
            <article>
                <div class="title">Codeforces Round #510 (Div. 2)</div>
                <div class="author">By Me</div>
                <div class="body">
                    <p>Hello, Codeforces</p>
                    <p>Codeforces Round #510 (Div. 2) will start at Monday, September 17, 2018 at 11:05. The round will
                        be
                        rated for Div. 2 contestants (participants with the rating below 2100). Div. 1 participants can
                        take
                        a part out of competition as usual.</p>
                    <p>This round is held on the tasks of the school stage All-Russian Olympiad of Informatics 2018/2019
                        year in city Saratov. The problems were prepared by PikMike, fcspartakm, Ne0n25, BledDest,
                        Ajosteen
                        and Vovuh. Great thanks to our coordinator _kun_ for the help with the round preparation! I also
                        would like to thank our testers DavidDenisov, PrianishnikovaRina, Decibit and Vshining.</p>
                    <p>UPD: The scoring distribution is 500-1000-1500-2000-2250-2750.</p>
                </div>
                <ul class="attachment">
                    <li>Announcement of <a href="#">Codeforces Round #510 (Div. 1)</a></li>
                    <li>Announcement of <a href="#">Codeforces Round #510 (Div. 2)</a></li>
                </ul>
                <div class="footer">
                    <div class="left">
                        <img src="img/voteup.png" title="Vote Up" alt="Vote Up"/>
                        <span class="positive-score">+173</span>
                        <img src="img/votedown.png" title="Vote Down" alt="Vote Down"/>
                    </div>
                    <div class="right">
                        <img src="img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                        <span class="creationTime">2 days ago</span>
                        <img src="img/comments_16x16.png" title="Comments" alt="Comments"/>
                        <a href="#">68</a>
                    </div>
                </div>
            </article>
        </template>
        <div class="textHolder">
            <p></p>
        </div>
    </div>

    <script>
        $(function () {
            const $textHolder = $(this).find(".textHolder");
            $textHolder.text("Loading...");
            const data = {"action": "findAll"}

            function callBack(response) {
                $textHolder.hide();
                response["articles"].forEach(function (article) {
                    const $newArticle = $($(".article template").prop("content")).clone();
                    $newArticle.find(".title").text(article["title"]);
                    $newArticle.find(".body").text(article["text"]);
                    $newArticle.find(".creationTime").text(article["creationTime"]);
                    $newArticle.find(".author").text(
                        "By " + response["users"].find(function (x) {
                            return x.id === article["userId"];
                        }).login
                    );

                    $(".article").append($newArticle);

                })
                if (Object.keys(response["articles"]).length === 0) {
                    $textHolder.show();
                    $textHolder.find("p").text("No articles found");
                }
            }

            ajax({data}, $textHolder, callBack);
        })
    </script>
</@c.page>
