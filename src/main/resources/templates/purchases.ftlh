<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <form method="post">
            <input type="text" name="name" placeholder="Название"/>
            <input type="text" name="count" placeholder="Количество"/>
            <input type="text" name="coast" placeholder="Стоимость"/>
            <button type="submit">Добавить покупку</button>
        </form>
    </div>
    <div>Список покупок</div>
    <#list purchases as purchase>
        <div>
            <span>${purchase.name}</span>
            <span>${purchase.count}</span>
            <span>${purchase.coast}</span>
            <span>${(purchase.date?date)!}</span>
        </div>
    <#else>
        No messages
    </#list>
</@c.page>
