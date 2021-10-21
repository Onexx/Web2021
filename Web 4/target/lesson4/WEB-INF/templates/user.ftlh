<#-- @ftlvariable name="handle" type="java.lang.String" -->
<#-- @ftlvariable name="user_id" type="java.lang.Long" -->
<#import "./common.ftlh" as c>

<@c.page>
    <#if handle?has_content>
        <#assign u = c.findBy(users, "handle", handle)!/>
    <#else>
        <#if user_id?has_content>
            <#assign u = c.findBy(users, "id", user_id)!/>
        </#if>
    </#if>
    <#if u?has_content>
        <div class="userInfo">
            <img class="userPicture" src="/img/no-title.jpg" alt="userPicture">
            <h1>
                ${u.name}
            </h1>
            <ul>
                <li>
                    id: ${u.id}
                </li>
                <li>
                    handle: ${u.handle}
                </li>
                <li>
                    name: ${u.name}
                </li>
            </ul>
        </div>
        <#assign ind = c.getIndex(users, "handle", u.handle)>
        <#if ind == 0>
            <div class="userArrow disabledArrow">←</div>
        <#else>
            <a href="/user?handle=${users[ind - 1].handle}" class="userArrow enabledArrow">←</a>
        </#if>
        <#if ind + 1 == users?size>
            <div class="userArrow disabledArrow">→</div>
        <#else>
            <a href="/user?handle=${users[ind + 1].handle}" class="userArrow enabledArrow">→</a>
        </#if>
    <#else>
        No such user
    </#if>
</@c.page>
