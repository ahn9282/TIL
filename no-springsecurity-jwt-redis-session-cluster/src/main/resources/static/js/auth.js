const Auth = {
    accessTokenKey: 'accessToken',
    refreshTokenKey: 'refreshToken',

    setTokens: (access, refresh) => {
        if (access) localStorage.setItem(Auth.accessTokenKey, access);
        if (refresh) localStorage.setItem(Auth.refreshTokenKey, refresh);
    },

    getAccessToken: () => localStorage.getItem(Auth.accessTokenKey),
    getRefreshToken: () => localStorage.getItem(Auth.refreshTokenKey),

    logout: () => {
        localStorage.removeItem(Auth.accessTokenKey);
        localStorage.removeItem(Auth.refreshTokenKey);
        window.location.href = '/login';
    },

    request: async (url, options = {}) => {
        const token = Auth.getAccessToken();
        
        const headers = {
            'Content-Type': 'application/json',
            ...options.headers
        };

        if (token) {
            headers['Authorization'] = `Bearer ${token}`;
        }

        const config = {
            ...options,
            headers: headers
        };

        try {
            const response = await fetch(url, config);

            if (response.status === 401) {
                console.warn("Access Token expired or invalid. Redirecting to login...");
                Auth.logout();
                return null;
            }

            return response;
        } catch (error) {
            console.error('Request failed:', error);
            throw error;
        }
    },
    
    isLoggedIn: () => {
        return !!Auth.getAccessToken();
    }
};
