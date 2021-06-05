<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <form method="post">
            <input type="text" name="name" placeholder="Название"/>
            <input type="text" name="description" placeholder="Описание"/>
            <button type="submit">Добавить категорию</button>
        </form>
    </div>
    <div>Список категорий</div>
    <#list categories as category>
        <div>
            <span>${category.name}</span>
            <span>${category.description}</span>
        </div>
    <#else>
        категорий нет
    </#list>
</@c.page>
