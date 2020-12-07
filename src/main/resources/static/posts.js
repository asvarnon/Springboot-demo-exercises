(function($) {
    let request = $.ajax({'url': '/posts.json'});
    request.done(function (posts) {
        let html = '';
        ads.forEach(function(post) {
            html += '<div>';
            html += '<h1>' + post.title + '</h1>';
            html += '<p>' + post.description + '</p>';
            html += '<p>Published by ' + post.owner.username + '</p>';
            html += '</div>';
        });
        $('#posts').html(html);
    });
})(jQuery);