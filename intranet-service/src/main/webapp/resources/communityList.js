window.onload = () => {
	let page = 1;

	const search = location.search.substring(1).split('&');
	search.forEach(e => {
		const data = e.split('=');
		if (data[0] === 'page')
			page = parseInt(data[1]);
	});

	changePage(page);
}

function changePage(page) {
	$.ajax({
		"url": `../service?command=CommunityListWithPage&page=${page}`,
		"method": "GET",
		"timeout": 0,
	}).done(function(response) {
		$('#contents-container').empty();
		response.list.forEach(content => {

			$('#contents-container').append(`
			<tr>
				<td>${content.writeCode}</td>
				<td><a href="readBoard?writeCode=${content.writeCode}">${content.title}</a></td>
				<td>${content.userCode}</td>
				<td>${content.regDate.toString().split(" ")[0]}</td>
			</tr>
			`);
		});

		// reponse.status // {key : value ...}
		const nextPage = response.status.nextPage;
		const totalPages = response.status.totalPages;
		const prevPage = response.status.prevPage;
		const currentPage = response.status.currentPage;

		if (prevPage >= 1) {
			$('#prev').attr('href', `?page=${prevPage})`);
		}
		renderPageNumber(currentPage, totalPages);
		if (nextPage <= totalPages) {
			$('#next').attr('href', `?page=${nextPage})`);
		}
	});
}


function renderPageNumber(currentPage, totalPages) {
	$('#pageNum-container').empty();
	for (let i = 1; i <= totalPages; i++) {
		if (i === currentPage) {
			$('#pageNum-container').append(`
				<span onclick='changePage(${i})' class="active">${i}</span>
			`);
		}
		else {
			$('#pageNum-container').append(`
				<span onclick='changePage(${i})'>${i}</span>
			`);
		}
	}
}