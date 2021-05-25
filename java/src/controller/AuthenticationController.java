package controller;

import java.net.http.HttpHeaders;

public class AuthenticationController {
	@RestController
	@CrossOrigin
	

	    private final TokenProvider tokenProvider;
	    private final AuthenticationManagerBuilder authenticationManagerBuilder;
	    private UserDAO userDAO;

	    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDAO userDAO) {
	        this.tokenProvider = tokenProvider;
	        this.authenticationManagerBuilder = authenticationManagerBuilder;
	        this.userDAO = userDAO;
	    }

	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginDTO loginDto) {

	        UsernamePasswordAuthenticationToken authenticationToken =
	                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

	        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = tokenProvider.createToken(authentication, false);
	        
	        User user = userDAO.findByUsername(loginDto.getUsername());

	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
	        return new ResponseEntity<>(new LoginResponse(jwt, user), httpHeaders, HttpStatus.OK);
	    }

	    @ResponseStatus(HttpStatus.CREATED)
	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public void register(@Valid @RequestBody RegisterUserDTO newUser) {
	        try {
	            User user = userDAO.findByUsername(newUser.getUsername());
	            throw new UserAlreadyExistsException();
	        } catch (UsernameNotFoundException e) {
	            userDAO.create(newUser.getUsername(),newUser.getPassword(), newUser.getRole());
	        }
	    }

	    /**
	     * Object to return as body in JWT Authentication.
	     */
	    static class LoginResponse {

	        private String token;
	        private User user;

	        LoginResponse(String token, User user) {
	            this.token = token;
	            this.user = user;
	        }

	        @JsonProperty("token")
	        String getToken() {
	            return token;
	        }

	        void setToken(String token) {
	            this.token = token;
	        }

	        @JsonProperty("user")
			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}
	    }
	}



