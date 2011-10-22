<div> El Jurado del Show</div>

Bienvenido: ${user.name}<br>

<img src="https://graph.facebook.com/${user.facebookId}/picture"/>

<div>.</div>

Participantes:
<g:each in="${dancers}" var="dancer">
	<div>${dancer.name} ${dancer.surname}</div>
</g:each>

<div>.</div>

Parejas:
<g:each in="${dancePartners}" var="dancePartner">
	<div>${dancePartner.dancer1.name} - ${dancePartner.dancer2.name}</div>
</g:each>

<div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=1"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_1.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=2"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_2.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=3"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_3.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=4"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_4.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=5"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_5.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=6"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_6.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=7"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_7.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=8"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_8.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=9"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_9.png"></a></div>
	<div style="float:left;"><a href="/arno/home/vote?dance=1&point=10"><img width="30" heigth="30" src="/arno/images/puntajes/puntaje_10.png"></a></div>
	
</div>

<div style="clear:both;">.</div>

<div><a href="/arno/home/play?dance=1">Votar</a></div>



