
    // Function to fetch blog posts from the servlet
    function fetchPosts() {
        fetch('posts.jsp')
            .then(response => response.json())
            .then(posts => {
                // Call function to display posts
                displayPosts(posts);
            })
            .catch(error => console.error('Error fetching posts:', error));
    }

    // Function to display blog posts on the webpage
    function displayPosts(posts) {
        // Get the container element for posts
        var postsContainer = document.getElementById('posts');

        // Clear existing content
        postsContainer.innerHTML = '';

        // Iterate over each post and create HTML elements to display them
        posts.forEach(post => {
            // Create elements for post title and content
            var postTitle = document.createElement('h2');
            postTitle.textContent = post.title;

            var postContent = document.createElement('p');
            postContent.textContent = post.content;

            // Create a container for the post
            var postContainer = document.createElement('div');
            postContainer.classList.add('post');

            // Append title and content to the post container
            postContainer.appendChild(postTitle);
            postContainer.appendChild(postContent);

            // Append the post container to the posts container
            postsContainer.appendChild(postContainer);
        });
    }

    // Call fetchPosts function when the page loads
    window.onload = fetchPosts;

