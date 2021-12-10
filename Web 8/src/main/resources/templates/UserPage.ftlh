<#import "commons.ftlh" as c>

<@c.page>
    <#if pageUser??>
        <div class="userInfo">
            <h1>
                ${pageUser.login}
            </h1>
            <ul>
                <li>
                    id: ${pageUser.id}
                </li>
                <li>
                    handle: ${pageUser.login}
                </li>
                <li>
                    creation time: ${pageUser.creationTime}
                </li>
            </ul>
        </div>
    <#else>
        <h1>No such user.</h1>
    </#if>
</@c.page>
