function myclick() {
		var pa = document.querySelector('.panier')
		window.setInterval(function() {
			pa.classList.toggle('pa')
		}, 1)
	}

	function myclick2() {
		var pa = document.querySelector('.panier')
		var Atr = pa.style.getAttribute('display')

		if (Atr == "block") {
			document.getElementById("panier").style.display = "none"
		}

		else {
			document.getElementById("panier").style.display = "block"
		}
	}

	function onMouse() {

		document.getElementById("menu").style.backgroundColor = "#0080ff"
	}

	function onMouseO() {
		document.getElementById("menu").style.backgroundColor = "#038cfc"
	}
	
	
	function onMouseO_2(){
		document.getElementById("img").style.boxShadow="0px 0px 20px black"
	}
	
	function onMouseOu_2(){
		document.getElementById("ns").style.boxShadow="none"
	}
	
	var imgs=["Image/Slide/livre1.jpg","Image/Slide/livre2.jpg","Image/Slide/livre3.jpg","Image/Slide/livre4.jpg","Image/Slide/livre5.jpg","Image/Slide/livre6.jpg"]
	
	var k=0
	function slides(){
		
		document.getElementById("slide").src=imgs[k];
		k++;
		if (k>5)
			k=0	
	}
	
	//setInterval(slides,3000)
